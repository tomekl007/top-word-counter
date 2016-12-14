To run tests:
    ./sbt test

To run locally:
 1. Install spark: brew install apache-spark (on  mac)
 2. ./sbt clean assembly
 3. ./find-top-phrases-local-runner.sh --pathToTextToAnalyze book_to_analyze.txt
 4. you could pass path to any text file to analyze as pathToTextToAnalyze argument :) 