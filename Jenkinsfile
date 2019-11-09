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
         parallel unitTest: {junit 'build/test-results/test/*xml'}, integrationTest: {sleep 10}, securityScan: {sleep 8}, sonarChecks: {sleep 10}, failFast: true    
        }
      }
    
    stage('Package'){
      steps {
         sh 'sleep 4'                  
       }
      }
    
    stage('Deploy'){
      steps {
         sh 'sleep 4'
       }
      }
    
    stage('Sanity'){
      steps {
         parallel generateReport: {sleep 10}, slackNotification: {sleep 5}, failFast: true            
       }
      }
       
    stage('Staging'){
      steps {
         parallel deploy: {sleep 10}, failFast: true
       }
      }
    
    stage('Approve PROD?'){
      timeout(time: 30, unit: 'SECONDS') {
          script {
            def INPUT_PARAMS =  input message: 'Please Provide Parameters',
                                parameters: [choice(name: 'PROMOTE_PROD', choices: ['YES','NO'].join('\n'), description: 'Please select the Environment')]
            env.PROMOTE_PROD = INPUT_PARAMS
          }
      }
    }
    
    stage('Production'){
      when{
        expression { env.PROMOTE_PROD == 'YES' }
      }
      steps {
         parallel deploy: {sleep 5}, failFast: true
       }
      }              
  }
}
