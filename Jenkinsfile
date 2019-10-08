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
         echo 'All good'
        }
      }  
       
   }

}
