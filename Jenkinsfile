pipeline {
    agent any

    stages {
        stage('Verify Tooling') {
            steps {
                bat '''docker info
                docker version
                docker compose version'''
            }
        }
        
        stage('Prune Docker Data') {
            steps {
                bat '''docker system prune -a --volumes -f'''
            }
        }
        
        stage('Start Container') {
            steps {
                bat 'docker compose -f docker-compose-v3.yml up -d --no-color --wait'
				 bat 'docker ps'
            }
        }
		
		 stage('Stop Container') {
            steps {
                bat 'docker compose -f docker-compose-v3.yml down'
            }
        }
    }
}
