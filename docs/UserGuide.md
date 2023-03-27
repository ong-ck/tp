# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

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

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
