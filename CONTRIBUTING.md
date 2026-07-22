# Contributing to Train Tracking App

We love your input! We want to make contributing to this project as easy and transparent as possible.

## Development Process

We use GitHub to host code, to track issues and feature requests, as well as accept pull requests.

### Pull Requests

1. Fork the repo and create your branch from `main`
   ```bash
   git checkout -b feature/AmazingFeature
   ```

2. Make your changes and commit them
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```

3. Push to the branch
   ```bash
   git push origin feature/AmazingFeature
   ```

4. Open a Pull Request describing your changes

### Coding Style

- Follow Kotlin conventions and best practices
- Use meaningful variable and function names
- Add comments for complex logic
- Keep functions small and focused

### Commit Messages

Use clear and descriptive commit messages in the imperative mood.

Example:
```
Add Google Maps integration for train tracking

- Implement MapScreen composable
- Add marker positioning for trains and stations
- Integrate LocationService for GPS tracking

Fixes #123
```

## Setup Development Environment

1. **Prerequisites**
   - Android Studio Flamingo or later
   - JDK 17
   - Android SDK 24+
   - Git

2. **Clone and Setup**
   ```bash
   git clone https://github.com/yourusername/train-tracking-app.git
   cd train-tracking-app
   ./gradlew build
   ```

## Running Tests

```bash
# Run all tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

## Reporting Bugs

Use GitHub issues to report bugs. Before creating a bug report, please check the issue list.

**When reporting a bug, include:**
- A clear, descriptive title
- Detailed description of the issue
- Steps to reproduce the behavior
- Expected behavior
- Screenshots if applicable

## License

By contributing, you agree that your contributions will be licensed under its MIT License.

Thank you for contributing! 🚂