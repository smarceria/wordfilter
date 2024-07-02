# Word Filter
This Java application filters words from a text file based on user-defined rules.

# Functionality
This program allows you to filter words in a text file based on various criteria:
- StartWith: Filter words starting with a specific string (e.g., filter words starting with "the").
- HasLengthMoreThan: Filter words exceeding a certain length (e.g., filter words longer than 5 characters).
- HasLengthAndStartsWith: Filter words with specific length and prefix (e.g. filter word with length 5 and starting with “m”)

# Features:
-	Input file path in local machine to be filtered
-	User-friendly input for specifying the filter rules
-	Outputs a list of filtered words.

# Usage
1.	**Download**: Clone or download the project from GitHub: https://github.com/smarceria/wordfilter.git
2.	**Build**: Navigate to the project directory and run:
   ``` mvn clean install ```
  	This command will download dependencies, compile the Java code, and create an executable JAR file.
4.	**Run**: Execute the program with the following command:
    ``` java -jar target/WordFilter-0.0.1-SNAPSHOT.jar <input_file.txt> <filter_rule> <rule_param> ```

    - <input_file.txt>: Path to the text file containing the words to be filtered.
    - <filter_rule>: rule name for filtering. Rule name currenlty implemented:
        -	StartsWith
        -	HasLengthMoreThan
        -	HasLengthAndStartsWith
    - <rule_param>: Text or Number as rule input to define the criteria
      <br/>Example:
      1.	Counts and returns the NUMBER of words (i.e. Strings) that start with "M" or "m"
          <br/>Run command:
          ``` java -jar target/WordFilter-0.0.1-SNAPSHOT.jar D:\data.txt StartsWith M ```
          <br/>This will filter words in "data.txt" starting with "M" or “m”
    
      2.	Returns all the words longer than 5 characters
          <br/>Run Command:
          ``` java -jar target/WordFilter-0.0.1-SNAPSHOT.jar D:\data.txt HasLengthMoreThan 5 ```
          <br/>This will display every word in “data.txt” which has length more than 5 letters
    
      4.	Returns the words has 4 letters and start with “Me”
        	<br/>Run Command:
          ``` java -jar target/WordFilter-0.0.1-SNAPSHOT.jar D:\data.txt HasLengthAndStartsWith 4 "Me" ```
          <br/>This will display every word in “data.txt” which has length 4 letters and starting with "Me"

# Technologies
  - Java: Programming Language (https://www.java.com/)
  - Maven: Dependency Management and Build Tool (https://maven.apache.org/)
  - Jenkins: Continuous Integration and Continuous Delivery (https://www.jenkins.io/)

# Project Structure
  - src/main/java/ : Contains Java source code for the application logic.
  - src/test/java/ : Contains unit tests for the code.
  - pom.xml : Maven project configuration file.

# Dependencies
The project utilizes standard Java libraries and doesn't require any additional dependencies.

# Build and Deployment
The project uses Maven for building and packaging. The ```mvn clean install``` command creates an executable JAR file in the target directory. This JAR file can be deployed on any system with Java installed.
<br/>Currently, this project utilizes a local Jenkins instance for a basic CI/CD pipeline. This pipeline automates tasks to ensure code quality and prepare the application for deployment.
<br/>Here's a breakdown of how it work:
1. Code Commit:
   When pushing code changes to your GitHub repository, Jenkins detects the update.
2. Build Stage:
  Jenkins triggers a build job that performs the following actions:
  - Clones the latest code from your GitHub repository.
  - Runs Maven commands (mvn clean install) to build the project, download dependencies, and create the JAR file.
  - Executes unit tests (mvn test) to ensure code functionality hasn't regressed.
3. Artifact Staging:
  Jenkins can stage the generated JAR file as an artifact in a local repository (e.g., within Jenkins itself) for future reference.

# Testing
Unit tests are included in the src/test/java directory to ensure code functionality.

# License
This project is free to use and modify for any purpose. 

# Contact
For any questions or feedback, feel free to contact me at stephanie.marceria@gmail.com
