/**
	@Description	: Jenkinsfile
	@author			  : Sanjeev Saxena
*/

def deploy(env){
  sh 'sleep 3'
}

def promoteProd(){
    try{
        def INPUT_PARAMS =  input message: 'Approve Production?',
                            parameters: [choice(name: 'PROMOTE_PROD', choices: ['YES','NO'].join('\n'), description: 'Choice is yours buddy :)')]
                            env.PROMOTE_PROD = INPUT_PARAMS
    } catch (err){
                env.PROMOTE_PROD = 'NO'
    }
}

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
          parallel unitTest: {junit 'build/test-results/test/*xml'}, integrationTest: {sleep 6}, securityScan: {sleep 5}, sonarChecks: {sleep 4}, failFast: true    
        }
      }
    
    stage('Package'){
      //agent { dockerfile true }
      steps {
         sh 'env'
       }
      }
    
    stage('Deploy'){
      steps {
         script { deploy('dev') }
       }
      }
    
    stage('Sanity'){
      steps {
         parallel generateReport: {sleep 3}, slackNotification: {sleep 2}, failFast: true            
       }
      }
   
    stage('Staging'){
      steps {
         parallel deploy: {sleep 4}, failFast: true
        }
      }
        
    stage('Approve'){
      steps{
        timeout(time: 30, unit: 'SECONDS') {
          script {
              promoteProd()
          }
        }
      }
    }
    
    stage('Production'){
      when{
        expression { env.PROMOTE_PROD == 'YES' }
      }
      steps {
         parallel deploy: {sleep 3}, failFast: true
       }
      }              
  }
}
