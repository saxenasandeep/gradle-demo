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
      	 sh 'find .'		
         sh '$gradle clean build'
        }
      }
    
    stage('Verify'){
      steps {
         step{
         echo 'step1'
         	parallel f1: {sleep 5}, f2: {sleep 10}, failFast: true    
         }
         step{
			echo 'step2'             
         }
        }
      }
    
     stage('Code Analysis'){
      steps {
         junit 'build/test-results/test/*xml'
       }
      }  
   }  
        
   }

