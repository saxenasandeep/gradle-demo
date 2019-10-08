
pipeline{
  
  agent any
    
  stages{
    stage('Prepare'){
      step {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/sanrocks123/gradle-demo']]])
        }
      }
    stage('Compile'){
      step {
			echo 'Compile'
			sleep 10        
        }
      }  
   }

}
