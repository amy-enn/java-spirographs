# ˏˋ°•*⁀➷ Spirograph Java App

This Java application allows you to create and visualize spirographs with custom parameters. It consists of two main files: `SpirographGUI.java` and `SpirographPanel.java`. 

## * ˚ ✦ SpirographGUI.java

`SpirographGUI.java` contains the main user interface of the application. It provides a simple graphical user interface for entering the parameters of the spirograph and then displays the generated spirograph. Here's a brief overview of the important components in this file:

- **Welcome Frame**: A welcome screen with a "Begin!" button that opens the input window when clicked.

- **Input Window**: The input window where users can input the values for `R` (radius of the fixed circle), `r` (radius of the moving circle), and `d` (distance of the drawing point from the center of the moving circle).

- **Make Spirograph Button**: Clicking this button parses user input and passes the values to create and display the spirograph.

- **displaySpirograph()**: This method creates a new frame for displaying the spirograph and adds a `SpirographPanel` to it.

## * ˚ ✦ SpirographPanel.java

`SpirographPanel.java` defines the custom `SpirographPanel` class, which extends `JPanel` and is responsible for rendering the spirograph. Key points about this class include:

- **Spirograph Parameters**: The class takes `R`, `r`, and `d` as input parameters for defining the spirograph.

- **`paintComponent()`:** This method is responsible for painting the spirograph on the panel.

- **`calculatePoint()`:** Calculates the coordinates of the point being drawn on the spirograph based on the current angle.

## * ˚ ✦ Usage

1. Run the `SpirographGUI` class.
2. Click the "Begin!" button on the welcome screen to open the input window.
3. Enter the values for `R`, `r`, and `d` in the input window - I recommend starting with 50 - 5 - 40 for your first spirograph to gauge generation size.
4. Click the "Make Spirograph" button to generate and display the spirograph!

## * ˚ ✦ Dependencies

This Java application uses Swing for creating the graphical user interface.

## * ˚ ✦ Note

- One some generations, you may notice a small artifact at the beginning of the spirograph drawing that looks like a scribble, as if the marker is unsure of where it is or what it's supposed to be doing.  I am stumped as to what this is from, but I'm still trying to find an answer.

- There is plenty of room for customization of colors, stroke width, etc with this app!

Enjoy creating beautiful spirographs ♡
