# CodingChallengeMongoDB
To run this program via the command line, we have to provide exactly one argument, which represents the absolute path of the JSON file we want to flatten.
This absolute path may be unique for each local machine. 
For example, to flatten sample1.json file, I had to run Main with an argument "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample1.json".
This string representing the address of a file is the first element of args[] array in stdin. 

Therefore, my program reads args[0] (the first argument of args[] array), creates the corresponding JSONObject using org.json library, and 
prints the flattened version of JSONObject to stdout.
