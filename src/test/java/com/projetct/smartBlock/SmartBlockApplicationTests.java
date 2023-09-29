package com.projetct.smartBlock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		properties = {
				"spring.security.oauth2.resourceserver.jwt.jwk-set-uri = http://<host>:<port>/auth/realms/your-realm/protocol/openid-connect/certs"}
)
class SmartBlockApplicationTests {

	@Test
	void contextLoads() {
	}

}
