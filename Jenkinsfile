pipeline {
    agent any
	
	 tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.6"
    }

    stages {
        stage('Verify Tooling') {
            steps {
                bat '''docker info
                docker version
                docker compose version'''
            }
        }
        
       // stage('Prune Docker Data') {
       //     steps {
       //         bat '''docker system prune -a --volumes -f'''
       //     }
       // }
        
        stage('Start Container') {
            steps {
                bat 'docker compose -f docker-compose-v3.yml up -d --no-color --wait'
				 bat 'docker ps'
            }
        }
		
		
		 stage('Run Test') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true clean install'
            }
			
			post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
		 stage('Stop Container') {
            steps {
                bat 'docker compose -f docker-compose-v3.yml down'
            }
        }
    }
}
