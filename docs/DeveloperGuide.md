# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the 
original source as well}

## Design

### Architecture
The **_Architecture Diagram_** given above explains the high-level design of `CLIAlgo`.

Given below is a quick overview of the main components and how they interact with each other.

#### Main components of the architecture

- `CLIAlgo`: consist of only 1 main method and it is responsible for initializing the componnents
in the correct sequence and connects them with each other during runtime.
- `commons`: Represents a collection of classes that are used by multiple other components. They are essential for 
reading and processing inputs from the user. It consist of:
  - `Ui`: Responsible for handling all interactions with the user.
  - `Parser`: Responsible for making sense of all commands entered by the user.
  - `Topic`: A class responsible for managing all files allocated to single topic in CS2040C.
  - `TopicManager`: A class responsible for handling operations involving all `Topic`.
- `command`: A collection of `Command` objects which handles the different functionalities of `CLIAlgo`.
- `file`: A collection of files used in CS2040C.
- `storage`: A collection of classes responsible for reading, storing and writing data to the hard disk.

#### How the architecture components interact with each other


### Parser
**API** : `Parser.java`
Here is a class diagram of the `Parser` component which is responsible for processing commands
and preparing the appropriate `Command` object.

![](.\\uml\\diagrams\\ParserClass.png "Parser Class Diagram")

The `Parser` component:

- Reads in the full command keyed in by the user through the `Ui` class.
- Extracts out the keywords from the command such as `command type`, `topic`, `file name` using
the `StringManipulation` interface.
- Verify the validity of the user's input command.
- Handle cases where the user keys in an invalid command.
- Returns the appropriate `Command` object that will be executed by `CLIAlgo`.


### Storage
**API** : `FileManager.java`

Here is a class diagram of the `FileManager` which facilitates the storage
function of the application.

![](.\\uml\\diagrams\\FileManagerClass.png "FileManager Class Diagram")

The `FileManager` component
- can save each `Topic`'s data as an individual `.txt` file
- can interpret `Note` objects as a `String` and store it into its 
corresponding `Topic`'s  `.txt`
- updates the corresponding `Topic`'s  `.txt` whenever a `add` or
`remove` command is called by the user
- reads from each `Topic`'s  `.txt` and returns a `Topic` object when
initializing the application


### TopoSort
**API** : `TopoCommand.java`

Here is a class diagram of the `TopoCommand` which facilitates the storage
function of the application.

![](.\\uml\\diagrams\\TopoCommandClass.png "TopoCommand Class Diagram")

The `TopoCommand` component
- can topologically sort `CS2040CFile` objects in a specific `topic` order
- can print out the list of topologically sorted `CS2040CFile` objects
- can check whether there are `CS2040CFile` objects within `CLIAlgo` and inform user if no such objects are saved


#### Add
**API** : `AddCommand.java`

Here is a class diagram of the `AddCommand` which is responsible for adding either code files or note files

![](.\\uml\\diagrams\\Add.png "AddCommand Class Diagram")

The `AddCommand` component
- can check if the CS2040CFile to be added into our CLIAlgo exists within the same directory as the program
- can check for the type of CS2040CFile, whether it is `.txt` or `.cpp` based on the name of the CS2040CFile
- can ensure that there are no files with repeated names such that all names of files added are unique

## Implementation
### Filter by keyword feature
#### Current Implementation
The filter mechanism is facilitated by `FilterCommand`. It extends `Command` with an overridden `execute()` method. The
`FilterCommand` has 2 different executions depending on the constructor used to instantiate it. During execution, the
`FilterCommand` object calls either the `getNotesByTopic()` or the `getAllNotesByTopic()` methods in the `TopicManager`.
Additionally, it implements the following operations.

- `printAllTopics()` - Prints out all notes stored in CLIAlgo that is sorted by `topic`.
- `printSingleTopic()` - Prints out all notes stored in CLIAlgo that is tagged to the given `topic`.

The access modifiers of these methods are `private` can can only be accessed within `FilterCommand`.

Given below is an example usage of how the filter mechanism behaves at each step.

> **Step 1**: The user enters a command. The full command is read in by the `Ui` and processed by the `Parser`. If the
> user entered a valid command, the `Parser` will process the full command using the `StringManipulation` interface and
> prepare the appropriate `FilterCommand` object.

> **Step 2**: If the `topic` field is left empty, the `Parser` will instantiate a new `FilterCommand` object, setting
> the `topic` field to be `null`. If the `topic` field is filled with a valid topic name, the `Parser` will instantiate
> a new `FilterCommand` using its constructor.


## Product scope
### Target user profile

- CS2040C students (but inclusive of other groups e.g. tutors)
- has a need to keep track of a significant number of notes
- prefers desktop CLI over other available note manager application(s)
- prefers typing to mouse interactions

### Value proposition

Manage notes faster and more efficiently than a typical mouse/GUI driven application

## User Stories

| Version | As a(n) ...                                              | I want to ...                                                               | So that I can ...                                                            |
|---------|----------------------------------------------------------|-----------------------------------------------------------------------------|------------------------------------------------------------------------------|
| v1.0    | user                                                     | be able to add notes                                                        | view them later                                                              |
| v1.0    | user                                                     | be able to delete notes                                                     | replace existing notes with new ones                                         |
| v1.0    | user                                                     | be able to save my notes                                                    | reuse the saved data after closing and reopening the application             |
| v1.0    | user                                                     | list all my notes                                                           | see the amount of content I have to study                                    |
| v1.0    | first time user                                          | to be able to know how to use the application                               | N/A                                                                          |
| v1.0    | tutor teaching CS2040C                                   | organize my notes according to their topic                                  | easily find the relevant content                                             |
| v1.0    | student in CS2040C                                       | be able to study CS2040C according to their topic linkages in Visualgo      | study the prerequisite topics for more advanced topics                       |
| v1.0    | efficiency-obsessed student in CS2040C                   | be able to find relevant topic notes easily                                 | study the relevant topics efficiently                                        |
| v2.0    | organized student in CS2040C                             | be able to sort my notes according to level of importance                   | identify which topics to study first when I am preparing for my exam         |
| v2.0    | As a student in CS2040C                                  | be able to list my notes in topological sort order                          | study the prerequisite topics first before studying the more advanced topics | 
| v2.0    | As a CS2040C student with weekly programming assignments | be able to save my `.cpp` files                                             | refer to them in the future                                                  |
| v2.0    | As a student in CS2040C                                  | be able to extract out relevant files into a folder                         | easily access them during revision                                           |
| v2.0    | As an advanced user of CLIAlgo                           | be able to chain commands such that they will be executed one after another | use CLIAlgo more efficiently                                                 |

## Use Cases

(For all use cases below, the **System** refers to the `CLIAlgo` Notes Manager and the **Actor** is the `user` unless specified otherwise)

**Use case: Delete a note**

**MSS**
1. User requests to list notes
2. CLIAlgo shows the list of notes saved
3. User requests to delete a specific note (based off the notes on the list)
4. CLIAlgo deletes the note

Use case ends.

**Extensions**
- 2a. The list is empty
1. CLIAlgo prints an error message and prompts user to view the `help` command.

Use case ends.

- 3a. The user-input note name is invalid (does not exist)
1. CLIAlgo prints an error message and prompts user to view the `help` command.

Use case ends.

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 notes without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4. Should be able to handle situations where data files are corrupted (i.e. missing or altered fields)
5. Should be easily reusable for other developers who wish to create a similar app.
6. Should be easily maintainable and modifiable, by having private attributes and methods which reduces dependencies between different parts of the program
7. Should be secure in terms of protecting sensitive data such as name and path of files and preventing unauthorised access to them.
8. Should be able to execute user commands in no longer than 2 seconds.

## Glossary

* *notes* - A note file saved by the user as a `.txt` or `.cpp`
* *desktop CLI* - The terminal in Windows, Linux or macOS
* *mainstream OS* - Windows, Linux or macOS
* *CS2040C* - The Data Structures and Algorithms module in NUS
* *Visualgo* - A webpage developed by Professor Steven Halim for use in modules such as CS2040C
* *topics* - One of the ten topics taught in CS2040C

## Instructions for manual testing

Below are guidelines for testers to test the application

### Initialisation
1. Download the jar file and copy into an empty folder
2. Right click in the folder where the jar file is located and open the 
command-line interface. 
_**Example:**_ `` Open in Terminal``
3. Type: ``java -jar .\[NAME OF JAR FILE]`` where ``[NAME OF JAR FILE]``
is the file name of the jar file.
4. The application would then open in the command-line interface.
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

### Adding a `Note`
1. Type the command: `add n/[NOTE NAME] t/[TOPIC NAME]`.
   1. `[NOTE NAME]` would represent the name of the note.
      1. The note file is in the form `[NOTE NAME].txt`.
   2. `[TOPIC NAME]` would represent the `Topic` the note is tagged to.
      1. **CASE 1 :** The `[TOPIC NAME]` is valid.
      > Example : 
      > 
      > add n/note name t/LINKED_LIST
      2. **CASE 2 :** The `[TOPIC NAME]` is invalid.
      > Example :
      >
      > add n/note name t/linkedlist
      > 
      > add n/note name t/SOMETHING
2. Leaving any fields blank would cause an error message to be printed.
> Example :
>
> add n/ t/
> 
> add n/note t/
3. Leaving out `n/` or `t/` would cause an error message to be printed.
> Example :
>
> add note LINKED_LIST

### Listing all `Notes`
1. Type the command: `list`.
   1. **CASE 1 :** There are some `Notes` stored.
      1. The application would print out all the `Notes` stored.
   2. **CASE 2 :** There are no `Notes` stored.
      1. The application would print out a message indicating that no 
      notes have been stored.

### Deleting a `Note`
1. Type the command: `remove n/[NOTE NAME]`.
   1. `[NOTE NAME]` would represent the name of the note.
   2. **CASE 1 :** The `Note` with `[NOTE NAME]` exists.
      1. The `Note` is deleted successfully and a message would be printed.
   3. **CASE 2 :** The `Note` with `[NOTE NAME]` does not exist.
      1. The application would print out an error message indicating 
      that the note does not exist.
2. Leaving any fields blank would cause an error message to be printed. 
> Example :
>
> remove n/
3. Leaving out `n/` or `t/` would cause an error message to be printed.
> Example :
>
> remove note

### Filtering `Notes`
1. Type the command: `filter k/[KEYWORDS] t/[TOPIC NAME]`.
   1. `[KEYWORD]` would be `topic` representing filtering by `Topic`
   2. `[TOPIC NAME]` would represent the `Topic` the note is tagged to.
      1. **CASE 1 :** The `[TOPIC NAME]` is valid.
      > Example :
      >
      > filter k/topic t/LINKED_LIST
      2. **CASE 2 :** The `[TOPIC NAME]` is invalid.
      > Example :
      >
      > filter k/topic t/linkedlist
      >
      > filter k/topic t/SOMETHING
2. Leaving `k/` blank would cause an error message to be printed.
> Example :
>
> filter k/
3. Leaving out `t/` is valid
> Example :
>
> filter k/topic

### Saving data
1. Notes are represented as : 
`[NOTE NAME]&@[PATH TO NOTE]&@[TOPIC NAME]`
2. The application checks for invalid `[TOPIC NAME]` only
3. The application checks that there are three fields separated by `&@`
4. Corrupted lines of files are ignored by the application and removed 
subsequently
> Example:
> 
> Initial .txt file:
> 
> TEST1&@test1.txt&@wrr
> 
> TEST2&@test2.txt&@SORTING
> 
> After running application:
> 
> TEST2&@test2.txt&@SORTING

> Example:
>
> Initial .txt file:
>
> TEST1&@
>
> TEST2test2.txtSORTING
>
> After running application:
5. If a file is deleted in the middle of the application running somehow the 
application would recreate the file in its last state when running `add` or 
`remove` 