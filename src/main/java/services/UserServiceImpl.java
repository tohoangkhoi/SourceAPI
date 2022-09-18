package services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.AppUser;
import models.Role;
import org.springframework.stereotype.Service;
import repositories.RoleRepo;
import repositories.UserRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService {
    // If failed, add @Transactional --> Transactional is already used in SimpleJpaRepositories
    // and it's the default implementation of JpaRepository
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save((role));
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        return null;
    }

    @Override
    public List<AppUser> getUsers() {
        return null;
    }
}
