.PHONY: run pack tests sh3d env


sh3d:
	# sweethome3d /j3d.version=1.5.2 $(PWD)/data/wall.sh3d
	sweethome3d $(PWD)/data/wall.sh3d

run: pack sh3d

pack:
	# mvn package -Dmaven.test.skip=true
	mvn compile assembly:single

tests:
	mvn package

env:
	echo $(PWD)
