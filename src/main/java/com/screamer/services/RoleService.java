package com.screamer.services;

import com.screamer.entities.Role;
import com.screamer.repos.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

//this service is used for perform role related operation.
@Service
public class RoleService {

    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo)
    {
        this.roleRepo = roleRepo;
    }

    public Role addRole(Role role)
    {
        return roleRepo.save(role);
    }

    public Role updateRole(Role role)
    {
        return roleRepo.save(role);
    }

    public Role getRoleById(Integer roleId){
        return roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public List<Role> getRoles()
    {
        return roleRepo.findAll();
    }

    public void deleteRoleById(Integer roleId)
    {
        Role role = roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        roleRepo.delete(role);
    }


}
