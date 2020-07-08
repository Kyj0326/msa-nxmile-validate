package com.skcc.nxm.core.application.devcrud.etc.controller;


import com.skcc.nxm.core.application.devcrud.etc.dto.CodeReqDto;
import com.skcc.nxm.core.application.devcrud.etc.dto.OrganDto;
import com.skcc.nxm.core.domain.entity.etc.*;
import com.skcc.nxm.core.port_infra.persistent.etc.ICodeRepository;
import com.skcc.nxm.core.port_infra.persistent.etc.ICommonCodeRepository;
import com.skcc.nxm.core.port_infra.persistent.etc.IGroupCodeRepository;
import com.skcc.nxm.core.port_infra.persistent.etc.IOrganCodeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/** +
 *  개발기에서만 사용 됨.
 */
@Slf4j
@AllArgsConstructor
@RestController
@Profile("dev")
@RequestMapping(value = "/etc" )
public class EtcController {

    private final ICodeRepository codeRepository;
    private final ICommonCodeRepository commonCodeRepository;
    private final IGroupCodeRepository groupCodeRepository;
    private final IOrganCodeRepository organCodeRepository;
    private final ModelMapper modelMapper;




    @PostMapping( value = "/code")
    public ResponseEntity<Object> createCode(@RequestBody CodeReqDto codeDto){

        GroupCode groupCode = new GroupCode();
        CommonCode commonCode = new CommonCode();
        Code code = new Code();

        GrpCommonCode grpCommonCode = GrpCommonCode.ORGANCODE_R1;
        groupCode.setGrpCode(grpCommonCode.getGroupCode());
        groupCode.setName(codeDto.getName());
        groupCodeRepository.save(groupCode);

        commonCode.setCommonCode(grpCommonCode.getCommonCode());
        commonCode.setName(codeDto.getName());
        commonCodeRepository.save(commonCode);
        groupCode.addCommonCode(commonCode);

        code.setCode(codeDto.getCode());
        code.setName(codeDto.getName());
        commonCode.addCode(code);
        codeRepository.save(code);






        return ResponseEntity.ok(codeDto);

    }

    @PostMapping( value = "/organ")
    public ResponseEntity<Object> createOrgan(@RequestBody OrganDto organDto) {

        return ResponseEntity.ok(organCodeRepository.save(modelMapper.map(organDto, OrganCode.class)));
    }

    @GetMapping( value = "/code/{groupCode}")
    public ResponseEntity<Object> getCode(@PathVariable String groupCode){
        return ResponseEntity.ok(groupCodeRepository.findById(groupCode));
    }

    @GetMapping( value = "/organ/{organCode}")
    public ResponseEntity<Object> getOrgan(@PathVariable String organCode){
        return ResponseEntity.ok(organCodeRepository.findById(organCode));
    }


    @DeleteMapping( value = "/code/{groupCode}")
    public void deleteCode(@PathVariable String groupCode){
        groupCodeRepository.deleteById(groupCode);
    }

    @DeleteMapping( value = "/organ/{organCode}")
    public void deleteOrgan(@PathVariable String organCode){
        organCodeRepository.deleteById(organCode);
    }


}
