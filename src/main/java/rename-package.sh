find * -name \*.java -type f \
| while read -r javaFile; do
   packagePath=$(dirname "${javaFile}")
   packageName=${packagePath//\//.}
   sed -i "1s/.*/package ${packageName};/" "${javaFile}"
done
