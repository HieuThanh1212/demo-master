package com.vmo.springboot.Demo.controllers;

import com.vmo.springboot.Demo.constant.EProcess;
import com.vmo.springboot.Demo.dto.Request.ReceivableRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ReceivableResponseDto;
import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.model.Receivable;
import com.vmo.springboot.Demo.services.ElectricBillServiceIpml;
import com.vmo.springboot.Demo.services.Interface.IGenericService;
import com.vmo.springboot.Demo.services.Interface.ILeases;
import com.vmo.springboot.Demo.services.LeasesServiceIpml;
import com.vmo.springboot.Demo.services.ReceivableServiceIpml;
import com.vmo.springboot.Demo.services.WaterBillServiceIpml;
import com.vmo.springboot.Demo.services.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.vmo.springboot.Demo.controllers.ResponseController.responseUtil;

@RestController
@RequestMapping("/api")
public class ReceivableController {
    @Autowired
    ReceivableServiceIpml receivableService;
    @Autowired
    LeasesServiceIpml leasesService;
    @Autowired
    MailService mailService;

    @PostMapping("/rec/add")
    public ResponseEntity<ResponseDto> createReceivable(@Valid @RequestBody ReceivableRequestDto receivableRequestDto) {
        try {
            Leases leases = leasesService.getByIdLeases(receivableRequestDto.getLeasesId());


            Receivable receivable = receivableService.createReceivable(receivableRequestDto, leases);
            return responseUtil.getSuccessResponse(receivable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("rec/{id}")
    public ResponseEntity<ResponseDto> updateReceivable(@Valid @RequestBody ReceivableRequestDto receivableRequestDto, @PathVariable int id) {
        try {
            Receivable receivable = receivableService.getByIdReceivable(id);
            if (receivable == null) {
                return responseUtil.getSuccessResponse("not found receivable");
            }
            if (receivableService.updateReceivable(receivableRequestDto, receivable) == null) {
                return responseUtil.getBadRequestResponse("out of date or this name existed");
            }
            return responseUtil.getSuccessResponse(receivable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("rec/{id}")
    public ResponseEntity<ResponseDto> deleteReceivable(@PathVariable int id) {
        try {
            Receivable receivable = receivableService.getByIdReceivable(id);
            if (receivable == null) {
                return responseUtil.getSuccessResponse("not found receivable");
            }
            receivableService.disableReceivable(receivable);
            return responseUtil.getSuccessResponse(receivable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "rec/all")
    public ResponseEntity<ResponseDto> getAllReceivable() {
        try {
            List<Receivable> receivables = receivableService.findAllReceivables();
            if(receivables.size() == 0) {
                return responseUtil.getSuccessResponse("empty");
            }
            return responseUtil.getSuccessResponse(receivables);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "rec/allname")
    public ResponseEntity<ResponseDto> getAllByNameReceivable(@RequestParam(value = "name") String name) {
        try {
            List<Receivable> receivables = receivableService.findAllReceivablesByName(name);
            if(receivables.size() == 0) {
                return responseUtil.getSuccessResponse("empty");
            }
            return responseUtil.getSuccessResponse(receivables);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "rec/{id}/detail")
    public ResponseEntity<ResponseDto> getDetailReceivableById(@PathVariable(value = "id") int id) {
        try {
            ReceivableResponseDto receivable = receivableService.getDetailById(id);
            if (receivable == null) {
                return responseUtil.getSuccessResponse("not found receivable");
            }
            return responseUtil.getSuccessResponse(receivable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
            //hihi
    @GetMapping(value = "/{id}/sendmail")
    public ResponseEntity<ResponseDto> sendReceivabletoBill(@PathVariable int id) {
        try {
            Receivable receivable = receivableService.getByIdReceivable(id);
            if (receivable == null) {
                return responseUtil.getSuccessResponse("not found receivable");
            }
            receivableService.sendMailToUser(receivable);
            return responseUtil.getSuccessResponse(receivableService.formatEmailReceivable(receivable));
        } catch (Exception e) {
            e.printStackTrace();
        } return null;
    }

}
