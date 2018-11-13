pipelineJob('Pipeline Basic Job') {

  def repo = 'https://github.com/keidrun/target_repo.git'

  description("Pipeline for $repo")

  triggers {
    scm('H/5 * * * *')
  }

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('master')
          scriptPath('misc/Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}
