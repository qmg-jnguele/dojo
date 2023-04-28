# dojo

A place to put bits of code for coding dojo sessions.

## Run tests

```
./gradlew clean test
```

## First session: Extract till you drop

Inspired by [Uncle Bob's blog from 2009 on Clean Code](https://sites.google.com/site/unclebobconsultingllc/one-thing-extract-till-you-drop),
more specifically about making functions do one thing and one thing only.

Classes of interest:
- SymbolReplacer
- SymbolReplacerTest

The goal of the session is practicing the extract till you drop technique to make each function do one thing and one thing
only. Why? While this may increase the number of lines in the code, it will make it more accessible and reduce the
cognitive load of the developer to pick it up. Meaningfully extracting smaller functions from bigger ones makes the 
codebase be more human-friendly.