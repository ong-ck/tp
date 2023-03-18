# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

- CS2040C students (but inclusive of other groups e.g. tutors)
- has a need to keep track of a significant number of notes
- prefers desktop CLI over other available note manager application(s)
- prefers typing to mouse interactions

### Value proposition

Manage notes faster and more efficiently than a typical mouse/GUI driven application

## User Stories

| Version | As a(n) ...                            | I want to ...                                                          | So that I can ...                                                |
|---------|----------------------------------------|------------------------------------------------------------------------|------------------------------------------------------------------|
| v1.0    | user                                   | add notes                                                              | view them later                                                  |
| v1.0    | user                                   | delete notes                                                           | replace the existing notes                                       |
| v1.0    | user                                   | save notes                                                             | reuse the saved data after closing and reopening the app         |
| v1.0    | tutor teaching CS2040C                 | organize my notes by topic                                             | easily find the relevant content                                 |
| v1.0    | student in CS2040C                     | be able to study CS2040C according to their topic linkages in Visualgo | study the prerequisite topics for more advanced topics           |
| v1.0    | efficiency-obsessed student in CS2040C | be able to find relevant topic notes easily                            | study the relevant topics efficiently                            |
| v1.0    | user                                   | list all my notes                                                      | see the amount of content I have                                 |
| v2.0    | organized student in CS2040C           | sort my notes according to level of importance                         | know which topics to study first when I am preparing for my exam |

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

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
