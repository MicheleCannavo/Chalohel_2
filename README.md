# 1. MyIOConsole

Questa piccola libreria e' stata costrutita per gestire gli aspetti legati agli Input/Output da console.

## UML
```plantuml
@startuml
class util.console.Input {
- <<Create>> Input()
+ {static} String readLine(String,Object)
+ {static} String readPassword()
  }
  class util.console.Output {
- <<Create>> Output()
+ {static} void printLine(String,Object)
+ {static} void printnlLine(String,Object)
+ {static} void printNotValid()
+ {static} void printIsPresent(String)
  }
  class util.console.Console {
- <<Create>> Console()
+ {static} void clrscr()
  }
  @enduml
```

## Struttura

La libreria è composta da un solo _package_ contenenti 3 classi:
