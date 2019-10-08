
pipeline{
  
  agent any
    
  stages{
    
    stage('Prepare'){
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/sanrocks123/gradle-demo']]])
        }
      }
   
     
   }

}
