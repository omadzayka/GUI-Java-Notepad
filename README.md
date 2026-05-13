# 📝 Java Notepad

A desktop Notepad application built with Java Swing. Features a clean text editor with file management, word wrap toggle, font customization, and background color themes.

---

## Features

- **File Management** — New, Open, Save, and Save As support
- **Word Wrap** — Toggle word wrap on or off
- **Font Customization** — Choose between Arial, Comic Sans MS, and Times New Roman
- **Font Size** — Options ranging from 8 to 24
- **Color Themes** — Switch background between White, Red, and Yellow

---

## Technologies Used

- **Java** — Core programming language
- **Java Swing** — GUI framework for the desktop interface
- **AWT (Abstract Window Toolkit)** — Event handling and layout

---

## Installation & How to Run

### Requirements
- Java JDK 8 or higher installed on your machine

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/java-notepad.git
   cd java-notepad
   ```

2. **Compile the project**
   ```bash
   javac *.java
   ```

3. **Run the application**
   ```bash
   java GUI
   ```

---

## Project Structure

```
java-notepad/
├── Main.java           # Main GUI class, entry point
├── function_file.java  # Handles file operations (open, save, new)
├── function_format.java# Handles font and word wrap settings
├── function_color.java # Handles background color changes
└── README.md
```

---

## Future Improvements

- Add more font options and custom font size input
- Add Edit menu functionality (undo, redo, cut, copy, paste)
- Add a dark mode theme
- Add a status bar showing line/column count
- Support for more file formats (e.g. `.rtf`)

---

## Author
