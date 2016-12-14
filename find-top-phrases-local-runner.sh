#!/usr/bin/env bash


usage(){
	echo "Usage: $0 --pathToTextToAnalyze [path]"
	exit 1
}


if [[ "$#" -lt 2 ]]; then
    usage
fi


spark-submit \
--class com.tomekl007.FindTopPhrasesJob \
--master local[*] \
top-words-counter/target/scala-2.10/top-words-counter-assembly-0.1.jar $@