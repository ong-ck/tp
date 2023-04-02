# Ong Hee Jet - Project Portfolio Page

## Overview
CLIAlgo is a desktop application for **managing your CS2040C notes and code**. It is optimized to be used via a Command
Line Interface (CLI). If you can type fast, you can access and sort your notes faster than ever before.

### Summary of Contributions

#### Features Implemented

1. List all `CS2040CFile`s.
   - **What it does**: Allows users of `CLIAlgo` to list all the `CS2040CFile`s that are tracked by `CLIAlgo`. Each 
   `CS2040CFile` is also labelled as either a `CODE` or a `NOTE` file based on its file extension. `.cpp` files are
   labelled with `[CODE]` and files with `.txt` are labelled with `[NOTE]`.
   
   - **Justification**: By having the `list` feature, users can keep track on the number and type of notes stored within
   `CLIAlgo` which helps them in their revision. The labels serve as an important visual markers for them to identify
   relevant files when completing their weekly assignment and preparing for the practical exam (`[CODE]` files) or when
   they are preparing for the midterms and finals (`[NOTE]` files).

   - **Highlights**: The implementation of this feature uses the `ArrayList` data structure to pass around the list of
   all `CS2040CFile`. The concept of polymorphism was used to allow `ArrayList` to hold two different objects(`Note`
   and `Code`). I have also written the `printListOfCS2040CFiles()` method in the `Ui` class so that `ArrayList` can be
   printed without duplicating code.
   
2. Filter by importance.
   - 