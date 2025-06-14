
Environmental Impact Simulator
Project Overview
The Environmental Impact Simulator is an interactive Java desktop application that allows users to input their daily activities (e.g., transportation, energy usage, water consumption, and diet choices) and analyze their environmental impact. The project calculates the total energy usage, carbon emissions, water usage, and costs associated with the activities. Users can view actionable recommendations to reduce their impact and visualize results through an interactive bar chart.

Technologies Used
1. Java (JDK 17+)
Core programming language.
Used for logic, data handling, and interaction between components.
Swing: For building the Graphical User Interface (GUI).
2. Java Swing
Used for creating the interactive forms and visualizing results.
Components like JTextField, JComboBox, JButton, and JTable are used to collect and display user data.
3. Java AWT and Graphics2D
AWT is used to handle low-level GUI rendering.
Graphics2D: Renders the bar chart visualization.
4. Java Collections Framework
List: To store user inputs as a list of Activity objects.
Map: For organizing data categories.
5. Object Serialization
Serializable: Used for saving and loading user activity data to/from files.
6. Maven
Build automation tool.
Manages dependencies (e.g., exec-maven-plugin) and organizes the project structure.
7. File I/O
FileStorage.java manages saving and loading data using serialized files.
Prerequisites
Ensure the following software/tools are installed:

Java Development Kit (JDK 17+)
Apache Maven (3.6+ recommended)
Visual Studio Code or any preferred IDE (IntelliJ, Eclipse, etc.).

Energy	            200.0	                20.0	                100.0
Water Usage	        50.0	                150.0	                30.0
Diet	            80.0	                5.0	                    40.0

