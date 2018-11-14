multibranchPipelineJob('Mutibranch Pipeline Basic Job') {

  def repo = 'https://github.com/keidrun/target_repo.git'

  description("Multi-Branch Pipeline for $repo")

  branchSources {
    git {
      remote (repo)
      credentialsId('github-jenkins-credentials')
      includes('JENKINS-*')
      excludes('tags/*')
    }
  }

  orphanedItemStrategy {
    discardOldItems {
      numToKeep(20)
    }
  }

  triggers {
    periodic(1440) // daily
  }

}
