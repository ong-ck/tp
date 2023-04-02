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
   
2. Filter by topic.
   - **What it does**: The filter by topic feature has two executions. The first execution occurs when the optional
   `topic` field in the command is left empty. In this version, `CLIAlgo` prints out all `CS2040CFiles` that are tracked
   by the application. The `CS2040CFiles` are grouped according to the `topic` they are tagged to. The second execution
   of the filter by topic feature occurs when the user provides a valid `topic` in the `topic` field. In this execution, 
   `CLIAlgo` only prints `CS2040CFile`(s) tagged to the `topic` provided by the user. 

   - **Justification**: This feature allows users to easily view the relevant learning materials they are looking for.
   For example, if they want to study a specific chapter such was `SORTING`, they can use this command to extract out 
   relevant files to aid in their revision.

   - **Highlights**: The implementation of this feature was challenging as there are a total of 10 topics, each with
   their own set of notes. To implement this feature elegantly and efficiently, the 'HashMap' data structure was used
   to access the various `topics` in CS2040C in approximately O(1) time. The relevant `CS2040CFile`(s) can then be
   extracted and printed to the user.

#### Code Contributed
The code contributed by me can be found on [RepoSense](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=Ong%20Hee&sort=totalCommits%20dsc&sortWithin=totalCommits%20dsc&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=functional-code~docs~test-code~other&since=2023-02-17&tabOpen=true&zFR=false&tabType=authorship&tabAuthor=heejet&tabRepo=AY2223S2-CS2113-T15-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false).

#### Documentation

#### Team-based tasks
- Created labels and milestones in the team's Github repository.
- Organized weekly online meetings and discussions.
- Created issues based on work assigned during team meetings.
- Compiled and build final `.jar` files for releases.
- Distributed workload among team members.
- Set internal deadlines each iteration.
- Review team members PR with non-trivial comments.
   