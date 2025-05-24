#!/bin/bash

# Auto-commit script for Arcane Codex development
# This script automatically commits changes with descriptive messages
# and can bump versions when requested

cd "$(dirname "$0")"

# Parse command line arguments
BUMP_VERSION=""
while [[ $# -gt 0 ]]; do
    case $1 in
        --bump-patch)
            BUMP_VERSION="patch"
            shift
            ;;
        --bump-minor)
            BUMP_VERSION="minor"
            shift
            ;;
        --bump-major)
            BUMP_VERSION="major"
            shift
            ;;
        *)
            echo "Unknown option: $1"
            echo "Usage: $0 [--bump-patch|--bump-minor|--bump-major]"
            exit 1
            ;;
    esac
done

# Function to bump version
bump_version() {
    local bump_type=$1
    local current_version=$(grep "mod_version" gradle.properties | cut -d'=' -f2)
    
    IFS='.' read -ra VERSION_PARTS <<< "$current_version"
    MAJOR=${VERSION_PARTS[0]:-0}
    MINOR=${VERSION_PARTS[1]:-0}
    PATCH=${VERSION_PARTS[2]:-0}
    
    case "$bump_type" in
        major)
            MAJOR=$((MAJOR + 1))
            MINOR=0
            PATCH=0
            ;;
        minor)
            MINOR=$((MINOR + 1))
            PATCH=0
            ;;
        patch)
            PATCH=$((PATCH + 1))
            ;;
    esac
    
    NEW_VERSION="$MAJOR.$MINOR.$PATCH"
    
    # Update gradle.properties
    sed -i "s/mod_version=.*/mod_version=$NEW_VERSION/" gradle.properties
    
    # Update mods.toml
    sed -i "s/version=\".*\"/version=\"$NEW_VERSION\"/" src/main/resources/META-INF/mods.toml
    
    # Update README if it contains version
    sed -i "s/Version: .*/Version: $NEW_VERSION/" README.md 2>/dev/null || true
    
    echo "Version bumped from $current_version to $NEW_VERSION"
    
    # Stage version files
    git add gradle.properties src/main/resources/META-INF/mods.toml README.md 2>/dev/null || true
}

# Function to generate commit message based on changed files
generate_commit_message() {
    local changed_files=$(git diff --name-only --cached)
    local message="Development progress: "
    
    if echo "$changed_files" | grep -q "src/main/java.*blocks"; then
        message+="blocks, "
    fi
    if echo "$changed_files" | grep -q "src/main/java.*items"; then
        message+="items, "
    fi
    if echo "$changed_files" | grep -q "src/main/java.*research"; then
        message+="research system, "
    fi
    if echo "$changed_files" | grep -q "src/main/java.*particles"; then
        message+="particles, "
    fi
    if echo "$changed_files" | grep -q "src/main/java.*capabilities"; then
        message+="capabilities, "
    fi
    if echo "$changed_files" | grep -q "src/main/java.*gui"; then
        message+="GUI, "
    fi
    if echo "$changed_files" | grep -q "src/main/java.*network"; then
        message+="networking, "
    fi
    if echo "$changed_files" | grep -q "src/main/resources"; then
        message+="resources, "
    fi
    if echo "$changed_files" | grep -q "\.md$"; then
        message+="documentation, "
    fi
    if echo "$changed_files" | grep -q "\.yml$"; then
        message+="CI/CD, "
    fi
    
    # Remove trailing comma and space
    message=${message%, }
    
    # Add version bump info if applicable
    if [[ -n "$BUMP_VERSION" ]]; then
        message+="\n\nVersion bump: $BUMP_VERSION"
    fi
    
    # Add file count
    local file_count=$(echo "$changed_files" | wc -l)
    message+="\n\n- Modified $file_count files"
    
    echo -e "$message"
}

# Bump version if requested
if [[ -n "$BUMP_VERSION" ]]; then
    bump_version "$BUMP_VERSION"
fi

# Check if there are changes
if [[ -n $(git status -s) ]]; then
    echo "Changes detected, preparing commit..."
    
    # Stage all changes
    git add -A
    
    # Generate commit message
    commit_msg=$(generate_commit_message)
    
    # Commit changes
    git commit -m "$commit_msg"
    
    echo "Changes committed successfully!"
    
    # Push to remote (uncomment to enable auto-push)
    # git push origin $(git branch --show-current)
    
    # Create and push tag if version was bumped
    if [[ -n "$BUMP_VERSION" ]]; then
        NEW_VERSION=$(grep "mod_version" gradle.properties | cut -d'=' -f2)
        git tag -a "v$NEW_VERSION" -m "Release v$NEW_VERSION"
        echo "Created tag: v$NEW_VERSION"
        
        # Push tag (uncomment to enable auto-push)
        # git push origin "v$NEW_VERSION"
    fi
else
    echo "No changes to commit."
fi