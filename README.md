JACOCO
-----------------

<img width="1914" height="615" alt="image" src="https://github.com/user-attachments/assets/5e9ff6cf-e215-452f-8a27-996ff3a850de" />

JACOCO BUILD FOR POM 
-------------------------------
```Java
<build>
        <plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.13</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```
