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
- If the buffer is empty when `export` is inputted, `./export` 
would be empty.
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

```
filter k/topic
======================================================
The filtered list is empty!
======================================================
export
```
Here `./export` after `export` is input with an empty `Buffer`.
![](.\\images\\export2.png)

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
