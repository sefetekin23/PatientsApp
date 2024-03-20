# Section 1: Program Features Summary
This program is a comprehensive web application designed to manage and display patient
data. It implements all the coursework requirements except requirement 8:
1. Patient Data List and Sort: Users can view a list of patients, each with specific
attributes like names and IDs which the list can be sorted accordingly.
2. Detailed Patient Information: By selecting a patient, users can access and easily
copy more detailed information, showcasing the application's ability to manage and
present data dynamically.
3. Search Functionality: A search feature enables users to query patient data based on
keywords, enhancing the application's usability for end-users seeking specific
information. The results show which section of the patient has the keyword and can
easily access the general information by clicking on it.
4. Patient Data Stats and Visualisation: A section called “Fun Stats” displays
information about interesting facts. Underneath it, there are graphical displays of
some of the data without the use of external libraries but pure html/css. The title of
each bar is written on them and the number for that bar can be viewed by moving the
cursor onto the bar.
5. Downloading as JSON: By clicking “Download JSON”, the csv file can be
downloaded as a properly formatted JSON file without losing any information.
These features together provide a user-friendly platform for accessing and managing patient
data, demonstrating the application's utility in healthcare data management contexts.
# Section 2: Design and Programming Process
# Designing Classes
The application is built on a foundation of well-thought-out classes, each serving a distinct
role in managing patient data:
• DataLoader: Responsible for reading patient data from CSV files and initializing
data structures.
• DataFrame and Column: These classes represent the structure of patient data,
facilitating its manipulation and access throughout the application.
• Model: Acts as the central hub for data interaction, providing methods to read data,
fetch detailed patient information, and perform searches.
• JSONWriter: Responsible for converting the default csv file to a JSON file in the
correct format and with all the information. Utilized for the “Download JSON”
feature with its static toJSON(DataFrame dataframe) function.
These classes are designed with the principles of cohesion, encapsulation, and abstraction in
mind. For instance, the DataLoader class abstracts away the complexities of CSV parsing,
while the DataFrame provides a flexible structure for representing tabular data.
# Use of Model-View-Controller (MVC):
• Model: Utilizes DataFrame class to perform different tasks on the data. It is used by
Servlets to make the required changes to data.
o Model.java Class: Contains functions that uses DataFrame functions.
• View: JSP files along with CSS generates the webpages.
o footer.jsp File: Included in every page and contains a sample copyright.
o header.jsp File: Included in every page and contains the title with a link to
main page.
o index.jsp File: The main page of the website, contains the navigation bar, fun
stats, and graphs.
o patientInfo.jsp File: Generates the individual information page for every
patient which contains all the information sections in the given csv file.
o patientList.jsp File: Shows a list of all patients and one of their properties
(default = ID). Also has the sort dropdown menu which when selected a
property, sorts the list accordingly and displays that property for each patient.
o search.jsp File: The search page with the search bar and included in
searchResult.jsp as well.
o searchResult.jsp File: Shows the results of the searched keyword and has the
search bar for any other searchs. Can access the individual patient info by
clicking on them.
• Controller: All Servlets have a model object to perform the necessary actions to data.
They are responsible for receive a http request, call methods on the model to carry out
actions on the data and forward the result data to a JSP to display the results.
o DownloadJsonServlet.java Servlet: Responsible for downloading JSON file
when the button on the navigation bar is clicked.
o PatientInfoServlet.java Servlet: Responsible for fetching the list of individual
information for any patient given the ID parameter.
o SearchResultServlet.java Servlet: Responsible for fetching a list of results
and ids to be able to access the individual information pages.
o SearchServlet.java Servlet: Responsible for the search bar.
o SortServlet.java Servlet: Responsible for fetching the sorted list of patient
names, patient IDs, column names, info according to the selected category.
o StatServlet.java Servlet: Responsible for fetching the fun stats strings and
hashmaps for graphs.
o ViewPatientListServlet.java Servlet: Responsible for fetching the list of
patient names, patient IDs, column names, info.
## Programming Process
I started from the basic requirements which helped me understand how the project should be
designed. When the basic requirements were done, I tried the challenges requirement. Since
at that point I was very practiced, the challenges weren’t as hard as I imagined
## Evaluation of the Design
The design exhibits a strong adherence to object-oriented principles:
• Cohesion: Each class has a clear, singular responsibility, enhancing understandability
and maintainability.
• Abstraction: Details of data parsing and representation are nicely abstracted away,
allowing the servlets to interact with patient data at a higher level.
• Encapsulation: Data is encapsulated within classes, with public methods providing
controlled access, ensuring data integrity and security.
## Overall Quality
The application demonstrates a solid understanding of Java servlets, object-oriented design,
and web development principles. The use of HTML, CSS, and JavaScript enhances the user
interface, making it accessible and intuitive to use. The backend architecture, built around
core Java classes and servlets, efficiently handles data management tasks, ensuring the
application's scalability and maintainability.