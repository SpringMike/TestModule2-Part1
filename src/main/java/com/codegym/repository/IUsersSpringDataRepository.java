package com.codegym.repository;

import com.codegym.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUsersSpringDataRepository extends PagingAndSortingRepository<Users, Long> {
}
