#!/bin/bash
gradle --stop

# live reload part 1, in background
gradle build --continuous & 

#live reload part 2, depends of devtools
gradle bootRun