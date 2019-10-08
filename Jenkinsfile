
pipeline{
  
  agent any
    
  stages{
    stage('Build'){
      steps('checkout') {
        //checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/sanrocks123/gradle-demo']]])
      }
      steps('compile') {
		gradle clean build     
      }
    }
    
   }

}
