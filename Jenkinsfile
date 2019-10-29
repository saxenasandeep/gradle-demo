/**
	@Description	: Jenkinsfile
	@author			  : Sanjeev Saxena

*/

pipeline{

  agent any

  environment{
  		gradle = './gradlew'
  }	 	 	    

  stages{
    stage('Prepare'){
      steps {
         echo pwd()
         sh 'chmod 777 gradlew'
        }
      }
    stage('Build'){
      steps {
      	 sh '$gradle clean build'		
      }
    }
    stage('Verify'){
      steps {
         parallel f1: {sleep 5}, f2: {sleep 10}, f3: {sleep 8}, failFast: true    
        }
      }
    stage('Code Analysis'){
      steps {
         junit 'build/test-results/test/*xml'
       }
      }  
  }
}
