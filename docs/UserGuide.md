# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

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
=======
## Features 

{Give detailed description of each feature}

### Adding a CS2040CFile: `add`
Adds a CS2040CFile that exists into our file manager. It could be either a note file or a code file. Requires a topic 
tagged to it, and an optional importance level, a number from 1 to 10.

#### Format: 
```
add n/CODE_NAME t/TOPIC_NAME [i/IMPORTANCE_LEVEL]
add n/NOTE_NAME t/TOPIC_NAME [i/IMPORTANCE_LEVEL]
```
- Not following the syntax strictly would result in an invalid command message. 
- Only full words will be matched. E.g. `LINKED_LIST` will not match `Link List`.
- `n/` and `t/` fields must be non-empty.
- `i/` field is optional.

#### Example of usage:
Input:
```
add n/queue t/LINKED_LIST
```
or
```
add n/queue t/LINKED_LIST i/5
```
Output:
```
======================================================
Successfully added queue into LINKED_LIST.
======================================================
```

### Removing a CS2040CFile: `remove`
Removes a CS2040CFile that exists from our file manager.

#### Format:
```
remove n/CODE_NAME
remove n/NOTE_NAME
```

- Not following the syntax strictly would result in an invalid command message.


#### Example of usage:
Input:
```
remove n/queue
```

Output:
```
======================================================
Successfully removed queue.
======================================================
```


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

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Copy all the CS2040CFiles as well as the data.txt file into the new Computer.

**Q**: How do I gain easy access to all my filtered or topologically sorted CS2040CFiles?

**A**: Enter the export command after filtering or topologically sorting your CS2040CFiles.

**Q**: What if I am unable to add because the program tells me that my CS2040CFile does not exist?

**A**: Ensure that all your CS2040CFiles are in the same directory as this `jar` file.


## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
