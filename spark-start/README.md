# spark-start

`spark-start` is a Maven Archetype for installing the following dependencies:

- postgresql
- hibernate-core
- hibernate-annotations
- hibernate-commons-annotations
- javassist
- spark-core
- velocity
- spark-template-velocity
- spark-debug-tools
- junit

## Installation

First, ensure you have installed maven:

```bash
brew install maven
```

Next, clone this project.

```bash
git clone git@github.com:johnmcc/spark-start.git
```

`cd` into the project, and install the archetype:

```bash
mvn install
```

Next, perform the following steps:

- Click "Create new project"
- Click "Create from archetype"
- Click "Add Archetype"

Enter the following information:

- GroupId: com.codeclan
- ArtifactId: spark-start
- Version: 1.0-SNAPSHOT

Click "OK", and the archetype should be installed. You can now use `spark-start`.
