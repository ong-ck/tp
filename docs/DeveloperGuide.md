# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

Below are guidelines for testers to test the application

### Initialisation
1. Download the jar file and copy into an empty folder
2. Right click in the folder where the jar file is located and open the 
command-line interface. 
_**Example:**_ `` Open in Terminal``
3. Type: ``java -jar .\[NAME OF JAR FILE]`` where ``[NAME OF JAR FILE]``
is the file name of the jar file.
4. The appliction would then open in the command-line interface.
5. Note that if the application has initialised correctly, there would be a 
`data` folder created with some `.txt` files in the same directory as the 
jar file.

#### _Optional : Test Mode_
1. If the tester does not want their data that they entered to be saved, they 
can type the command: `start-test-mode` to start a debugging mode 
after opening the application.
    1. If done correctly this is what the tester will see:
    ```
    ======================================================
     Starting test mode.
    ======================================================
    ```
   2. There would be a `testdata` folder created with some `.txt` files
   in the same directory as the jar file.
   3. All the below testing will then reflect in the `.txt` files in 
   the `testdata` folder.
      1. If manually editing the data file, it has to be done in the data 
      files within `testdata`.
2. To exit test mode, type the command `exit-test-mode`.
   1. If done correctly this is what the tester will see:
    ```
   ======================================================
    Ending test mode.
   ======================================================
   ======================================================
    Successfully deleted file.
   ======================================================
   ======================================================
    ```
3. The `testdata` folder should now be deleted.   

> **WARNING**
> 
> The user _has_ to exit test mode or the test mode data would not be 
> wiped correctly.

### Shutdown
1. After all the testing is done, type in the command: `exit`.
   1. If done correctly this is what the tester will see:
    ```
   ======================================================
   Thank you for using CLIAlgo! Study hard!
   ======================================================
    ```
   2. The application would then close in the command-line interface.