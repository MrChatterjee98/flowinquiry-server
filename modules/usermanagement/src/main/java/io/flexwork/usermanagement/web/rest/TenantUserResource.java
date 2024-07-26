package io.flexwork.usermanagement.web.rest;

import io.flexwork.platform.db.TenantConstants;
import io.flexwork.security.service.UserService;
import io.flexwork.security.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
public class TenantUserResource {

    private static final Logger log = LoggerFactory.getLogger(TenantUserResource.class);

    private final UserService userService;

    public TenantUserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Page<UserDTO> getUsers(Pageable pageable) {
        return userService.getAllPublicUsers(pageable);
    }

    @PostMapping("/users")
    public void createUser(
            @RequestHeader(value = TenantConstants.HEADER_TENANT_ID) String tenantId,
            @RequestBody UserDTO userDTO) {
        log.debug("REST request to save User: {} for tenant {}", userDTO, tenantId);
        //        userService.saveUser(UserMapper.instance.userDtoToUser(userDTO));
    }
}
