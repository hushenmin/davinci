/*
 * <<
 *  Davinci
 *  ==
 *  Copyright (C) 2016 - 2019 EDP
 *  ==
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  >>
 *
 */

package edp.davinci.dao;

import edp.davinci.dto.roleDto.RoleBaseInfo;
import edp.davinci.model.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {
    int insert(Role record);

    @Delete({
            "delete from `role` where id = #{id,jdbcType=BIGINT}"
    })
    int deleteById(Long id);

    @Select({
            "select * from `role` where id = #{id,jdbcType=BIGINT}"
    })
    Role getById(Long id);


    List<Role> getRolesByIds(List<Long> list);

    @Update({
            "update `role`",
            "set `org_id` = #{orgId,jdbcType=BIGINT},",
            "`name` = #{name,jdbcType=VARCHAR},",
            "`description` = #{description,jdbcType=VARCHAR},",
            "`create_by` = #{createBy,jdbcType=BIGINT},",
            "`create_time` = #{createTime,jdbcType=TIMESTAMP},",
            "`update_by` = #{updateBy,jdbcType=BIGINT},",
            "`update_time` = #{updateTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int update(Role record);


    @Select({
            "select id, `name`, description  from `role` where org_id = #{orgId}"
    })
    List<RoleBaseInfo> getBaseInfoByOrgId(Long orgId);


    List<Role> selectByIdsAndOrgId(@Param("orgId") Long orgId, @Param("roleIds") List<Long> roleIds);


    @Delete({"delete from `role` where org_id = #{orgId}"})
    int deleteByOrg(Long orgId);
}