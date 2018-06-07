.PHONY: run pack tests

run: pack
	sweethome3d ~/wall.sh3d

pack:
	# mvn package -Dmaven.test.skip=true
	mvn compile assembly:single

tests:
	mvn package
