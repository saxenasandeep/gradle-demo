pipeline{
  agent any
  stages{
    stage('checkout'){
      steps {
        echo 'checkout files:'
      }
    }
    stage('compile'){
      steps{
        gradle clean build --stacktrace
      }
    }
   }

}
