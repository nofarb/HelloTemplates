pipeline {
    agent any
    stages {
                stage ("deploy to Development") {
                    
                      steps {
                    withCfCli(
                        apiEndpoint: 'https://api.run.pivotal.io', 
                        cloudFoundryCliVersion: 'cloudfoundry-cli-6.22.1', 
                        credentialsId: 'nofar_cf', 
                        organization: 'cloudbees', 
                        space: 'development') {
                        sh """
                        cf push hello-world -p target/*.jar
                        """
                    }
                      }
            }      

        stage('notify') {
           steps {
                        echo "On Branch notify"
                        slackSend channel: 'templates_demo', color: '#439FE0',message: 'This is the message', teamDomain: 'cloudbees', tokenCredentialId: 'Jenkins-slack-integration'

                    }
        }
       
    }
}


