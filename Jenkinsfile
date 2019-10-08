/**
	@Description	: Jenkinsfile
	@author			: Sanjeev Saxena

*/

pipeline{
 
  agent any
  
  environment{
  		gradle = '/opt/gradle-4.4.1/bin/gradle'
  }	 	 	    
  
  stages{
    
    stage('Prepare'){
      steps {
         echo pwd()
        }
      }
   
    stage('Build'){
      steps {
      	 step{
      	 	sh 'find .'    
      	 }
		step{
         sh '$gradle clean build'
		}
        }
      }
    
    stage('Verify'){
      steps {
         parallel f1: {sleep 5}, f2: {sleep 10}, failFast: true    
        }
      }
    
     stage('Code Analysis'){
      steps {
         junit 'build/test-results/test/*xml'
       }
      }  
   }  
        
   }

