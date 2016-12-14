To run tests:
    ./sbt test

To run locally:
 1. git clone https://github.com/tomekl007/top-word-counter
 2. cd top-word-counter/
 3. Install spark: brew install apache-spark (on  mac)
 4. ./sbt clean assembly
 5. ./find-top-phrases-local-runner.sh --pathToTextToAnalyze book_to_analyze.txt book_to_analyze2.txt
 6. Find "result: " in standard output 
 7. you could pass path to any text file to analyze as pathToTextToAnalyze argument :)
  
To run on cluster:
 1.There should be yarn cluster setup (https://hadoop.apache.org/docs/r2.7.2/hadoop-project-dist/hadoop-common/ClusterSetup.html) to which job could be submitted
 2.Open deployToCluster.sh and replace #your_server_with_yarn_and_spark_support with address of remote server
 3.Open find-top-phrases-cluster-runner.sh and replace #{yarn_queue} with proper name of yarn queue. Also all spark related configs needs to be configured properly for remote machine setup
 4. ./find-top-phrases-local-runner.sh --pathToTextToAnalyze book_to_analyze.txt book_to_analyze2.txt
 5. you could pass path to any text file to analyze as pathToTextToAnalyze argument :)