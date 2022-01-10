#!/bin/bash

body() {
    IFS= read -r header
    printf '%s\n' "$header"
    "$@"
}

cat oceny.csv | body sort -k2 | rev | uniq -s1 | rev > ocenycleaned.csv
cat ocenycleaned.csv > oceny.csv
rm ocenycleaned.csv
