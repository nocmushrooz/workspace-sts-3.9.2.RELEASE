package snippet;

public class Snippet {
	public static void main(String[] args) {
			<dependency>
				<groupId>javax</groupId>
				<artifactId>javaee-web-api</artifactId>
				<version>6.0</version>
				<scope>provided</scope>
			</dependency>
		
			<dependency>
				<groupId>javax.servlet</groupId>
				<artifactId>jstl</artifactId>
				<version>1.2</version>
			</dependency>
		
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-webmvc</artifactId>
				<version>4.2.2.RELEASE</version>
			</dependency>
		
			<dependency>
				<groupId>org.springframework.security</groupId>
				<artifactId>spring-security-web</artifactId>
				<version>4.0.1.RELEASE</version>
			</dependency>
		
			<dependency>
				<groupId>org.springframework.security</groupId>
				<artifactId>spring-security-config</artifactId>
				<version>4.0.1.RELEASE</version>
			</dependency>
		
			<dependency>
				<groupId>org.hibernate</groupId>
				<artifactId>hibernate-validator</artifactId>
				<version>5.0.2.Final</version>
			</dependency>
		
		
			<dependency>
				<groupId>org.webjars</groupId>
				<artifactId>bootstrap</artifactId>
				<version>3.3.6</version>
			</dependency>
		
			<dependency>
				<groupId>org.webjars</groupId>
				<artifactId>jquery</artifactId>
				<version>1.9.1</version>
			</dependency>
		
			<dependency>
				<groupId>com.fasterxml.jackson.core</groupId>
				<artifactId>jackson-databind</artifactId>
				<version>2.5.3</version>
			</dependency>
		
			<dependency>
				<groupId>log4j</groupId>
				<artifactId>log4j</artifactId>
				<version>1.2.17</version>
			</dependency>
		
		</dependencies>
		
		<build>
			<pluginManagement>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.2</version>
						<configuration>
							<verbose>true</verbose>
							<source>1.8</source>
							<target>1.8</target>
							<showWarnings>true</showWarnings>
						</configuration>
					</plugin>
					<plugin>
						<groupId>org.apache.tomcat.maven</groupId>
						<artifactId>tomcat7-maven-plugin</artifactId>
						<version>2.2</version>
						<configuration>
							<path>/</path>
							<contextReloadable>true</contextReloadable>
						</configuration>
					</plugin>
				</plugins>
				</pluginManagement>
				</build>
				
	}
}
