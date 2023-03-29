# User Guide

## Introduction

CLIAlgo is a desktop application for managing your CS2040C notes and code. It is optimized to be used via a Command Line
Interface (CLI). If you can type fast, you can access and sort your notes faster than ever before.

## Quick Start

1. Ensure that you have Java <code>11</code> or above installed.
2. Down the latest version of `clialgo.jar` from [here](https://github.com/AY2223S2-CS2113-T15-1/tp/releases).
3. Copy the file to the folder you want to use as the home folder for your CS2040C notes.
4. Open a command terminal, ‘cd’ into the folder you put the .jar  file in, and use the `java -jar -clialgo` command to 
run the application.
5. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open 
the help window. Some example commands you can try are:
   - `add n/toposort t/SORTING`: add a 'toposort.txt' file as notes to the topic 'SORTING'
   - `list`: list all existing notes
   - `remove n/toposort`: remove the 'toposort.txt' note from the list

## Features

### Exporting `Files`
Whenever a `filter` or `topo` command is input by the user, the 
`Files` listed by the above commands would be stored in a 
`Buffer`. These stored `Files` can then be copied into 
`./export`.

Format: `export`
- If the Operating System has a valid file explorer, `./export` 
would be opened automatically.
- If the buffer is empty when `export` is inputted, an error message
would be printed.
- Every time `export` is called, the `Files` within `./export`
are deleted before the `Files` are copied into `./export`
- If a `File` stored in the `Buffer` does not exist for some reason 
(i.e. if the user deleted the `File`) an error message would be
printed for each `File` not found.

Example of usage:
```
filter k/topic
======================================================
Here are the filtered CS2040CFiles:
======================================================
[SORTING]
1. TEST
[LINKED_LIST]
1. Test1
======================================================
export
```
Here is `./export` opened after `export` is input.
![](.\\images\\export1.png)

### Listing CS2040CFiles `list`
List all CS2040CFiles (in any order) present in `CLIAlgo`.

#### Format:
```
list
```

- Command is **case-sensitive**.
- Command should only contain one word.
- Not following the syntax strictly would result in an invalid command message.

#### Example of usage:
Input:
```
list
```
Output:
```
======================================================
Here are all your CS2040CFiles:
======================================================
1. priority queue notes
2. bubble sort note
3. linked list code
======================================================
```

### Filtering CS2040CFiles `filter`
Filters the CS2040CFiles by a user-specified keyword and prints a list of CS2040CFiles filtered based
on the keyword.

#### Format:
```
filter k/KEYWORD [t/TOPIC_NAME]
```
- Only specific `KEYWORD` can be used to filter.
  - Valid `KEYWORD` includes: `topic`, `importance`.
- `KEYWORD` and `TOPIC_NAME` are **case-sensitive**.
- `TOPIC_NAME` is an optional input and leaving it blank would result in `CLIAlgo` printing all 
CS2040CFiles.
- Not following the syntax strictly would result in an invalid command message.

#### Example of usage:

Filtering without providing `TOPIC_NAME`.

Input:
```
filter k/topic
```
Output:
```
======================================================
Here are the filtered CS2040CFiles:
======================================================
[SORTING]
1. bubble sort
[LINKED_LIST]
1. linked list code
2. linked list note
======================================================
```

Filtering according to `TOPIC_NAME`.

Input:
```
filter k/topic t/LINKED_LIST
```
Output:
```
======================================================
Here are the filtered CS2040CFiles:
======================================================
[LINKED_LIST]
1. linked list code
2. linked list note
======================================================
```

### Viewing help `help`
Shows a message explaining the format of supported commands in the application and their functions. If a valid command 
is entered after ‘help’ using the `c/` delimiter, it shows the format and function of that specific command instead.

#### Format:
`help [c/COMMAND_TYPE]`
- `COMMAND_TYPE` is **case-sensitive** and is an optional input

#### Example of usage:
Input:
```
help
```
Output:
```
======================================================
The available COMMAND_TYPE(s) are:
[add]: add CS2040CFile
[remove]: remove CS2040CFile
[list]: displays all CS2040CFiles
[filter]: filters CS2040CFiles by topic
[exit]: close the application
For more help on a specific command, type `help c/COMMAND_TYPE`
======================================================
```
Input:
```
help c/add
```
Output:
```
======================================================
This function adds a CS2040CFile and tags it to a topic.
The syntax for the 'add' command is: add n/NAME t/TOPIC.
NAME refers to the CS2040CFiles' file name.
TOPIC refers to the topic that NAME will be tagged to.
Case sensitive. NAME and TOPIC fields must be non-empty.
Invalid NAME or TOPIC will cause an error.
Valid TOPIC's are 'SORTING', 'LINKED_LIST', 'GRAPH_STRUCTURES',
'BINARY_HEAP', 'HASH_TABLE', 'GRAPH_TRAVERSAL', 'BINARY_SEARCH_TREE',
'SS_SHORTEST_PATH', 'UNION_FIND_DS' and 'MINIMUM_SPANNING_TREE'.
======================================================
```


## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
